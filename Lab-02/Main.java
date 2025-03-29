public class Main {
    public static void main(String[] args) {
        // Cria o ambiente com largura 10, altura 10 e profundidade 5
        Ambiente ambiente = new Ambiente(10, 10, 5);

        // Adiciona alguns obstáculos no ambiente
        ambiente.adicionarObstaculo(3, 4);
        ambiente.adicionarObstaculo(5, 5);
        ambiente.adicionarObstaculo(7, 2);
        ambiente.adicionarObstaculo(3, 2);
        ambiente.adicionarObstaculo(6, 8);

        // Cria e adiciona os robôs ao ambiente

        // RoboTerrestreDestruidor: posição inicial (2,2), velocidade máxima 5 e força de destruição 10
        RoboTerrestreDestruidor destruidor = new RoboTerrestreDestruidor("Destruidor", "norte", 2, 2, 5, 10);
        ambiente.adicionarRobo(destruidor);

        // RoboTerrestreExplorador: avança para o leste a partir da posição (0,0)
        RoboTerrestreExplorador explorador = new RoboTerrestreExplorador("Explorador", "leste", 0, 0, 5, ambiente);
        ambiente.adicionarRobo(explorador);

        // RoboAereoFalcao: posição inicial (6,6), altitude 3, altitude máxima 10 e alcance visual 4
        RoboAereoFalcao falcao = new RoboAereoFalcao("Falcao", "norte", 6, 6 , 3, 10, 4);
        ambiente.adicionarRobo(falcao);

        // RoboAereoObservador: posição inicial (7,7), altitude 2, altitude máxima 10 e raio de observação 3
        RoboAereoObservador observador = new RoboAereoObservador("Observador", "leste", 7, 7, 2, 10, 3);
        ambiente.adicionarRobo(observador);

        System.out.println("\n--- Teste de Movimentação Terrestre ---");
        // Movimentação do robô explorador: velocidade dentro do limite
        System.out.println("Movendo o Explorador com velocidade 4 (dentro do limite):");
        explorador.mover(1, 0, ambiente, 4);
        explorador.exibirPosicao();

        // Tentativa de movimentação acima do limite de velocidade
        System.out.println("Tentando mover o explorador com velocidade 6 (acima do limite):");
        explorador.mover(1, 0, ambiente, 6);
        explorador.exibirPosicao();

        System.out.println("\n--- Teste de Movimentação Aérea ---");
        // Testa o método subir do Falcao: subir 5 metros (dentro do limite)
        System.out.println("Subindo o Falcao 5 metros (dentro do limite)");
        falcao.subir(5);  // Ele passa de altitude 3 para 8
        // Tentativa de ultrapassar o limite de altitude
        System.out.println("Tentando subir o Falcao 3 metros (ultrapassa o limite)");
        falcao.subir(3);  // Tentativa de subir de 8 para 11, deve falhar

        System.out.println("\n--- Teste dos Métodos Específicos ---");
        // Testa o método identificar e destruir do robô destruidor
        destruidor.identificarObstaculo(ambiente);
        destruidor.destruirObstaculo(ambiente);
        // Após destruir, tente novamente para ver se já não há obstáculo
        destruidor.destruirObstaculo(ambiente);

        // Testa o método de exploração do robô explorador
        explorador.explorar(ambiente);
        explorador.exibirPosicao();

        // Testa o método específico do Falcao: varredura visual com alcance limitado
        falcao.visao(ambiente);
        falcao.exibirPosicao();

        // Testa o método específico do Observador: escaneamento em área
        observador.observar(ambiente);
        observador.exibirPosicao();

        System.out.println("\n--- Posições Finais dos Robôs ---");
        System.out.print("Destruidor: ");
        destruidor.exibirPosicao();
        System.out.print("Explorador: ");
        explorador.exibirPosicao();
        System.out.print("Falcao: ");
        falcao.exibirPosicaoAereo();
        System.out.print("Observador: ");
        observador.exibirPosicaoAereo();
    }
}
