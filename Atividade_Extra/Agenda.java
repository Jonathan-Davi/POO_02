import java.util.*;

public abstract class Agenda implements IAgenda {
    protected ArrayList<Contato> agendaDeContatos;
    protected Scanner scanner;

    public Agenda() {
        this.agendaDeContatos = new ArrayList<>();
        this.scanner = new Scanner(System.in);
        exibirMenu();
    }

    private void exibirMenu() {
        int opcao;
        do {
            System.out.println("\n--- MENU AGENDA ---");
            System.out.println("1 - Cadastrar Contato");
            System.out.println("2 - Buscar Contato");
            System.out.println("3 - Excluir Contato");
            System.out.println("4 - Imprimir Agenda");
            System.out.println("5 - Alterar Contato");
            System.out.println("6 - Sair");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1: 
                    cadastrarContato();
                    break;
                case 2: 
                    buscarContato();
                    break;
                case 3: 
                    excluirContato();
                    break;
                case 4: 
                    imprimirAgenda();
                    break;
                case 5: 
                    alterarContato();
                    break;
                case 6: 
                    System.out.println("Encerrando...");
                    break;
                default: 
                    System.out.println("Opção inválida.");
                    break;
            }
        } while (opcao != 6);
    }

    protected abstract void alterarContato();

    protected boolean telefoneExiste(Integer telefone) {
        return agendaDeContatos.stream().anyMatch(c -> c.getTelefone().equals(telefone));
    }

    protected boolean emailExiste(String emailStr) {
        return agendaDeContatos.stream().anyMatch(c -> c.getEmail().toString().equalsIgnoreCase(emailStr));
    }

@Override
    public void cadastrarContato() {
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Telefone: ");
        Integer telefone = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Email (formato nome@dominio): ");
        String[] emailSplit = scanner.nextLine().split("@");
        if (telefoneExiste(telefone)) {
            System.out.println("Telefone já cadastrado!");
            return;
        }
        if (emailExiste(emailSplit[0] + "@" + emailSplit[1])) {
            System.out.println("Email já cadastrado!");
            return;
        }
        Email email = new Email(emailSplit[0], emailSplit[1]);
        Contato contato = new Contato(nome, telefone, email);
        agendaDeContatos.add(contato);
        System.out.println("Contato cadastrado com sucesso!");
    }

@Override
    public void buscarContato() {
        System.out.print("Buscar por nome ou email: ");
        String termo = scanner.nextLine();
        List<Contato> encontrados = new ArrayList<>();
        for (Contato c : agendaDeContatos) {
            if (c.getNome().equalsIgnoreCase(termo) || c.getEmail().toString().equalsIgnoreCase(termo)) {
                encontrados.add(c);
            }
        }
        if (encontrados.isEmpty()) {
            System.out.println("Contato não encontrado!");
        } else {
            encontrados.forEach(System.out::println);
        }
    }

@Override
    public void excluirContato() {
        System.out.print("Informe o nome ou telefone do contato a excluir: ");
        String input = scanner.nextLine();
        Iterator<Contato> iterator = agendaDeContatos.iterator();
        boolean removido = false;
        while (iterator.hasNext()) {
            Contato c = iterator.next();
            if (c.getNome().equalsIgnoreCase(input) || c.getTelefone().toString().equals(input)) {
                iterator.remove();
                removido = true;
            }
        }
        System.out.println(removido ? "Contato removido com sucesso." : "Contato não encontrado.");
    }

@Override
    public void imprimirAgenda() {
        if (agendaDeContatos.isEmpty()) {
            System.out.println("Agenda vazia.");
        } else {
            for (Contato c : agendaDeContatos) {
                System.out.println(c);
            }
        }
    }
}