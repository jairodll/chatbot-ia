/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ia.chatbotia.Repository;

import com.ia.chatbotia.Entity.Gasto;
import com.ia.chatbotia.Entity.Usuarios;
import com.ia.chatbotia.projection.CatalogoProjection;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Oscar
 */
public interface CatalogoRepository extends CrudRepository<Gasto, Object> {

    @Query(value = "select c.id_catalogo,c.nombre_catalogo, c.descripcion_catalogo  "
            + "from cash_boot.catalogos c where c.codigo_catalogo = 1",
            nativeQuery = true)
    public List<CatalogoProjection> findCatalogoGastos();

    @Query(value = "select c.id_catalogo,c.nombre_catalogo, c.descripcion_catalogo  "
            + "from cash_boot.catalogos c where c.codigo_catalogo = 2",
            nativeQuery = true)
    public List<CatalogoProjection> findCatalogoTiposLimites();

}
