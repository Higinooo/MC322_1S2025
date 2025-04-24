import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Criação do ambiente
        Ambiente ambiente = new Ambiente(10, 10, 10);

        // Criação de robôs
        RoboAereoFalcao drone = new RoboAereoFalcao("Drone", "norte", 5, 5, 3, 10,2);
        drone.adicionarSensor(new SensorProximidade(3));
        drone.adicionarSensor(new SensorAltitude(10));

        RoboTerrestreDestruidor tanque = new RoboTerrestreDestruidor("Tanque", "leste", 2, 2, 5, 7);
        tanque.adicionarSensor(new SensorProximidade(2));
        // Adiciona robôs ao ambiente
        ambiente.adicionarRobo(drone);
        ambiente.adicionarRobo(tanque);

        // Criação de obstáculos
        ambiente.adicionarObstaculo(new Obstaculo(3, 2, 3, 2, TipoObstaculo.MURO));
        ambiente.adicionarObstaculo(new Obstaculo(5, 6, 5, 6, TipoObstaculo.PREDIO));

        // Menu interativo
        boolean executando = true;

        while (executando) {
            System.out.println("\n--- MENU INTERATIVO ---");
            System.out.println("1. Visualizar status dos robôs e do ambiente");
            System.out.println("2. Mover robô");
            System.out.println("3. Ativar sensores");
            System.out.println("4. Verificar colisões");
            System.out.println("5. Ativar habilidades");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("\nDimensoes do ambiente:\n" + "Largura: " + ambiente.getLargura() + "\nAltura: " + ambiente.getAltura() + "\nProfundidade: " + ambiente.getProfundidade());

                    System.out.println("\nObstaculos no ambiente:");
                    for (Obstaculo obs : ambiente.getObstaculos()) {
                        System.out.println("Tipo: " + obs.getTipo());
                        System.out.println("Posição: (" + obs.getPosicaoX1() + ", " + obs.getPosicaoY1() + ") até (" + obs.getPosicaoX2() + ", " + obs.getPosicaoY2() + ")");
                        System.out.println("Altura padrão: " + obs.getAltura());
                        System.out.println("Resistencia: " + obs.getResistencia() + "\n");
                    }

                    System.out.println("\nRobôs no ambiente:");
                    int index = 1;
                    for (Robo r : ambiente.getRobosAtivos()) {
                        if (r instanceof RoboAereo){
                            System.out.print(index + ". " + r.getNome());
                            System.out.print("\nTipo do robo: " + r.getClass().getSimpleName() + "\n");
                            ((RoboAereo)r).exibirPosicaoAereo();
                        }
                        else{
                            System.out.print(index + ". " + r.getNome());
                            System.out.print("\nTipo do robo: " + r.getClass().getSimpleName() + "\n");
                            r.exibirPosicao(); 
                        }
                        index++;
                    }
                    break;

                case 2:
                    System.out.println("\nEscolha o robô:");
                    for (int i = 0; i < ambiente.getRobosAtivos().size(); i++) {
                        Robo r = ambiente.getRobosAtivos().get(i);
                        System.out.println((i + 1) + ". " + r.getNome());
                    }

                    int escolha = scanner.nextInt();
                    scanner.nextLine();

                    if (escolha < 1 || escolha > ambiente.getRobosAtivos().size()) {
                        System.out.println("Opção inválida.");
                        break;
                    }

                    Robo escolhido = ambiente.getRobosAtivos().get(escolha - 1);

                    System.out.print("Delta X: ");
                    int dx = scanner.nextInt();
                    System.out.print("Delta Y: ");
                    int dy = scanner.nextInt();

                    if (escolhido instanceof RoboTerrestre) {
                        System.out.print("Velocidade: ");
                        int vel = scanner.nextInt();
                        ((RoboTerrestre) escolhido).mover(dx, dy, ambiente, vel);
                    } else { // instanceof RoboAereo
                        System.out.print("Delta Z: ");
                        int dz = scanner.nextInt();
                        escolhido.mover(dx, dy, ambiente);
                        if (dz < 0){
                            ((RoboAereo)escolhido).descer(dz*(-1));
                        }
                        else{
                            ((RoboAereo)escolhido).subir(dz);
                        }
                    }
                    break;

                case 3:
                    System.out.println("\nAtivando sensores de todos os robôs:");
                    for (Robo r : ambiente.getRobosAtivos()) {
                        System.out.println("\nSensores de " + r.getNome() + ":");
                        r.ativarSensores(ambiente);
                    }
                    break;

                case 4:
                    System.out.println("\nVerificando colisões...");
                    ambiente.detectarColisoes();
                    break;

                case 5:
                    System.out.println("\nEscolha o robô para ativar seu metodo especifico:");
                    for (int i = 0; i < ambiente.getRobosAtivos().size(); i++) {
                        Robo r = ambiente.getRobosAtivos().get(i);
                        System.out.println((i + 1) + ". " + r.getNome());
                    }

                    int e = scanner.nextInt();
                    scanner.nextLine();

                    if (e < 1 || e > ambiente.getRobosAtivos().size()) {
                        System.out.println("Opção inválida.");
                        break;
                    }

                    Robo es = ambiente.getRobosAtivos().get(e - 1);

                    if (es instanceof RoboTerrestreDestruidor){
                        System.out.println("Metodos especificos:\n 1 - DestruirObstaculo (descricao breve) ");
                        System.out.print("Escolha o numero do metodo: ");
                        int num = scanner.nextInt();
                        if (num == 1){
                            ((RoboTerrestreDestruidor)es).destruirObstaculo(ambiente);
                        }
                    }

                    else if (es instanceof RoboTerrestreExplorador){
                    System.out.println("Metodos especificos:\n 1 - Explorar (descricao breve) ");
                        System.out.print("Escolha o numero do metodo: ");
                        int num = scanner.nextInt();
                        if (num == 1){
                            ((RoboTerrestreExplorador)es).explorar(ambiente);
                        }
                    }

                    else if (es instanceof RoboAereoFalcao){
                        System.out.println("Metodos especificos:\n 1 - Visao (descricao breve) ");
                        System.out.print("Escolha o numero do metodo: ");
                        int num = scanner.nextInt();
                        if (num == 1){
                            ((RoboAereoFalcao)es).visao(ambiente);
                        }
                    }

                    else if (es instanceof RoboAereoObservador){
                        System.out.println("Metodos especificos:\n 1 - Observar (descricao breve) ");
                        System.out.print("Escolha o numero do metodo: ");
                        int num = scanner.nextInt();
                        if (num == 1){
                            ((RoboAereoObservador)es).observar(ambiente);
                        }
                    }
                    
                    break;
                
                case 0:
                    executando = false;
                    System.out.println("Encerrando o simulador...");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }
        }

        scanner.close();
    }
}
