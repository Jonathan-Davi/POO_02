public class Agenda_Avancada extends Agenda {
    @Override
    protected void alterarContato() {
        System.out.print("Entre com o nome ou telefone do contato para alterar: ");
        String input = scanner.nextLine();
        Contato contato = null;
        for (Contato c : agendaDeContatos) {
            if (c.getNome().equalsIgnoreCase(input) || c.getTelefone().toString().equals(input)) {
                contato = c;
                break;
            }
        }
        if (contato == null) {
            System.out.println("Contato não encontrado.");
            return;
        }

        int opcao;
        do {
            System.out.println("\n--- Alterar Contato ---");
            System.out.println(contato);
            System.out.println("1 - Alterar Nome");
            System.out.println("2 - Alterar Telefone");
            System.out.println("3 - Alterar Email");
            System.out.println("4 - Sair");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Novo nome: ");
                    contato.setNome(scanner.nextLine());
                    break;
                case 2:
                    System.out.print("Novo telefone: ");
                    Integer novoTel = scanner.nextInt();
                    scanner.nextLine();
                    if (telefoneExiste(novoTel)) {
                        System.out.println("Telefone já existe.");
                    } else {
                        contato.setTelefone(novoTel);
                    }
                    break;
                case 3:
                    System.out.print("Novo email (nome@dominio): ");
                    String[] novoEmail = scanner.nextLine().split("@");
                    String emailStr = novoEmail[0] + "@" + novoEmail[1];
                    if (emailExiste(emailStr)) {
                        System.out.println("Email já existe.");
                    } else {
                        contato.setEmail(new Email(novoEmail[0], novoEmail[1]));
                    }
                    break;
                case 4: System.out.println("Saindo da edição...");
                    break;
                default: System.out.println("Opção inválida.");
                    break;
            }
        } while (opcao != 4);
    }
}