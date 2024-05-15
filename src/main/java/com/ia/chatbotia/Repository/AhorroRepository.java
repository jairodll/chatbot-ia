/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ia.chatbotia.Repository;

import com.ia.chatbotia.Entity.Ahorros;
import com.ia.chatbotia.projection.ahorroProjection;
import com.ia.chatbotia.projection.mayorAhorroProjection;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author jairo
 */
@Repository
public interface AhorroRepository extends CrudRepository<Ahorros, Object> {

    @Query(value = "SELECT SUM(a.monto_ahorro) FROM cash_boot.ahorros a WHERE a.nit_usuario = :nit", nativeQuery = true)
    Integer sumAhorros(@Param("nit") String nit);

    @Query(value = "SELECT MAX(monto_gasto) AS mayorGasto, fecha_gasto as fechaGasto\n"
            + "FROM cash_boot.gastos\n"
            + "WHERE nit_usuario = :nit\n"
            + "  AND EXTRACT(MONTH FROM fecha_gasto) = EXTRACT(MONTH FROM CURRENT_DATE)\n"
            + "  AND EXTRACT(YEAR FROM fecha_gasto) = EXTRACT(YEAR FROM CURRENT_DATE)\n"
            + "GROUP BY fecha_gasto\n"
            + "ORDER BY MayorGasto DESC\n"
            + "LIMIT 1;", nativeQuery = true)
    List<ahorroProjection> mayorGasto(@Param("nit") String nit);

    @Query(value = "SELECT\n"
            + "  EXTRACT(MONTH FROM fecha_ahorro) AS mes,\n"
            + "  SUM(monto_ahorro) AS totalAhorro\n"
            + "FROM cash_boot.ahorros a\n"
            + "where a.nit_usuario = :nit\n"
            + "GROUP BY mes\n"
            + "LIMIT 1;", nativeQuery = true)
    List<mayorAhorroProjection> mayorAhorro(@Param("nit") String nit);
}
