package orm.actions;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import orm.model.Aluno;

public class InserirAluno {

    public static void main(String[] args) {
    	// Criação da fábrica de conexões
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("alunos");
        EntityManager manager = factory.createEntityManager();
        
        
        System.out.println("Cadastrar Aluno:\n");
        Aluno aluno = new Aluno();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o nome do aluno: ");
        String nome = scanner.nextLine();
        aluno.setNome(nome);

        System.out.print("Digite o e-mail do aluno: ");
        String email = scanner.nextLine();
        aluno.setEmail(email);

        System.out.print("Digite o CPF do aluno: ");
        String cpf = scanner.nextLine();
        aluno.setCpf(cpf);

        System.out.print("Digite a data de nascimento do aluno (formato: dd/mm/aaaa): ");
        String dataNascimentoStr = scanner.nextLine();
        LocalDate dataNascimento = LocalDate.parse(dataNascimentoStr, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        aluno.setDataNascimento(dataNascimento);
        
        System.out.print("Digite a naturalidade do aluno: ");
        String naturalidade = scanner.nextLine();
        aluno.setNaturalidade(naturalidade);

        System.out.print("Digite o endereço do aluno: ");
        String endereco = scanner.nextLine();
        aluno.setEndereco(endereco);

        manager.getTransaction().begin();
        manager.persist(aluno);
        manager.getTransaction().commit();

        System.out.println("Aluno cadastrado com sucesso!");

        manager.close();
        factory.close();
        scanner.close();
    }
}
