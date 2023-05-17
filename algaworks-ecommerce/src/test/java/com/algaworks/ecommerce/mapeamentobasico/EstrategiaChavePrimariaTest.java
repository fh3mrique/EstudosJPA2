package com.algaworks.ecommerce.mapeamentobasico;

import com.algaworks.ecommerce.EntityManagerFabrica;
import com.algaworks.ecommerce.model.Categoria;
import org.junit.Assert;
import org.junit.Test;

public class EstrategiaChavePrimariaTest extends EntityManagerFabrica {

    @Test
    public void testarEstrategiaIdentity(){
        Categoria categoria = new Categoria();

        categoria.setNome("Eletronico");

        entityManager.getTransaction().begin();
        entityManager.persist(categoria);
        entityManager.getTransaction().commit();

        entityManager.clear();

        Categoria categoriaVerificacao = entityManager.find(Categoria.class, categoria.getId());

        Assert.assertNotNull(categoriaVerificacao);
    }

    /*A estratégia GenerationType.AUTO permite que o framework escolha automaticamente a
    melhor estratégia de geração de valores para chaves primárias com base no banco de
    dados e provedor de persistência utilizados. */
    @Test
    public void testarEstrategiaAuto(){
        Categoria categoria = new Categoria();

        categoria.setNome("Eletronico");

        entityManager.getTransaction().begin();
            entityManager.persist(categoria);
        entityManager.getTransaction().commit();

        entityManager.clear();

        Categoria categoriaVerificacao = entityManager.find(Categoria.class, categoria.getId());

        Assert.assertNotNull(categoriaVerificacao);
    }

    /*GenerationType.SEQUENCE: Utiliza sequências do banco de dados para gerar valores
    automaticamente. É importante ressaltar que nem todos os bancos de dados suportam
    sequências.*/
    @Test
    public void testarEstrategiaChave(){
        Categoria categoria = new Categoria();

        categoria.setNome("Eletronico");

        entityManager.getTransaction().begin();
        entityManager.persist(categoria);
        entityManager.getTransaction().commit();

        entityManager.clear();

        Categoria categoriaVerificacao = entityManager.find(Categoria.class, categoria.getId());

        Assert.assertNotNull(categoriaVerificacao);
    }

    /*GenerationType.TABLE: Utiliza uma tabela específica no banco de dados para gerar valores
    automaticamente.O framework mantém essa tabela para controlar a geração dos valores.*/
    @Test
    public void testarEstrategiaTable(){
        Categoria categoria = new Categoria();

        categoria.setNome("Eletronico");

        entityManager.getTransaction().begin();
        entityManager.persist(categoria);
        entityManager.getTransaction().commit();

        entityManager.clear();

        Categoria categoriaVerificacao = entityManager.find(Categoria.class, categoria.getId());

        Assert.assertNotNull(categoriaVerificacao);
    }
}
