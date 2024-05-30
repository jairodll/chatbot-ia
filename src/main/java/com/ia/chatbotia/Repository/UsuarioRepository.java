/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ia.chatbotia.Repository;

import com.ia.chatbotia.Entity.Usuarios;
import com.ia.chatbotia.projection.InformacionDTO;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author Oscar
 */
public interface UsuarioRepository extends CrudRepository<Usuarios, Object>{

    @Query(value = "select * from cash_boot.usuarios u where u.nombre_usuario=? limit 1",
            nativeQuery = true)
    public Usuarios findUsuarioByusername(String username);




 @Query(nativeQuery = true, value = "SELECT "
            + "im.monto_ingreso AS monto, "
            + "im.fecha_adicion AS fechaAdicion "
            + "FROM cash_boot.ingresos_mensuales im "
            + "WHERE im.nit_usuario = :nitUsuario")
    List<InformacionDTO> obtenerIngresos(@Param("nitUsuario") String nitUsuario);

    @Query(nativeQuery = true, value = "SELECT "
            + "c.descripcion_catalogo AS tipo, "
            + "lg.monto_limite AS monto, "
            + "lg.fecha_adicion AS fechaAdicion "
            + "FROM cash_boot.limite_gastos lg "
            + "INNER JOIN cash_boot.catalogos c ON lg.tipo_limite_id = c.id_catalogo "
            + "WHERE lg.nit_usuario = :nitUsuario")
    List<InformacionDTO> obtenerLimitesGastos(@Param("nitUsuario") String nitUsuario);

    @Query(nativeQuery = true, value = "SELECT "
            + "c.descripcion_catalogo AS tipo, "
            + "g.monto_gasto AS monto, "
            + "g.fecha_adicion AS fechaAdicion "
            + "FROM cash_boot.gastos g "
            + "INNER JOIN cash_boot.catalogos c ON g.tipo_gasto = concat(c.id_catalogo) "
            + "WHERE g.nit_usuario = :nitUsuario")
    List<InformacionDTO> obtenerGastos(@Param("nitUsuario") String nitUsuario);

    @Query(nativeQuery = true, value = "SELECT "
            + "a.monto_ahorro AS monto, "
            + "a.fecha_ahorro AS fechaAdicion "
            + "FROM cash_boot.ahorros a "
            + "WHERE a.nit_usuario = :nitUsuario")
    List<InformacionDTO> obtenerAhorros(@Param("nitUsuario") String nitUsuario);

    
}
