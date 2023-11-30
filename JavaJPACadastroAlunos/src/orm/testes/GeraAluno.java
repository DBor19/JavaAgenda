package orm.testes;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class GeraAluno {

    public static void main(String[] args) {
    	
    	// Criação da tabela alunos
        EntityManagerFactory factory= Persistence.createEntityManagerFactory("alunos");
        
        System.out.println("Tabela criada com sucesso!");

        factory.close();
    }
}
