/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ia.chatbotia.Repository;

import com.ia.chatbotia.Entity.IngresoMensual;
import com.ia.chatbotia.projection.ingresoProjection;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author Oscar
 */
public interface IngresoMensualRepository extends CrudRepository<IngresoMensual, Object> {

    @Query(value = "select im.ingreso_id as idIngreso,\n"
            + "	   im.monto_ingreso as montoIngreso,\n"
            + "	   im.mes_ingreso as mesIngreso\n"
            + "from cash_boot.ingresos_mensuales im \n"
            + "right join cash_boot.usuarios u \n"
            + "on im.nit_usuario = u.nit \n"
            + "where u.nit = :nit", nativeQuery = true)
    List<ingresoProjection> mostrarIngreso(@Param("nit") String nit);
}
