/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ia.chatbotia.Repository;

import com.ia.chatbotia.Entity.Gasto;
import com.ia.chatbotia.projection.gastoProjection;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author Oscar
 */
public interface GastoRepository extends CrudRepository<Gasto, Object> {

    @Query(value = "select u.nombre_usuario as nombreUsuario, \n"
            + "	   g.tipo_gasto as tipoGasto, \n"
            + "	   g.monto_gasto as montoGasto, \n"
            + "	   g.fecha_gasto as fechaGasto\n"
            + "	   from cash_boot.gastos g \n"
            + "right join cash_boot.usuarios u \n"
            + "on u.nit = g.nit_usuario \n"
            + "where u.nit = :nit", nativeQuery = true)
    List<gastoProjection> mostrarGastos(@Param("nit") String nit);

}
