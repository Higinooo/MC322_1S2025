// Robô terrestre que avança em linha reta até encontrar um obstáculo ou chegar ao fim do ambiente.
// Conta quantos passos conseguiu dar durante a exploração.

public class RoboTerrestreExplorador extends RoboTerrestre {
    private int passosDados;

    public RoboTerrestreExplorador(String nome, String direcao, int posicaoX, int posicaoY, int velocidadeMaxima, Ambiente ambiente) {
        super(nome, direcao, posicaoX, posicaoY, velocidadeMaxima);
        this.passosDados = 0;
    }

    public void explorar(Ambiente ambiente) {
        int x = getPosX();
        int y = getPosY();
        String dir = getDirecao().toLowerCase();

        System.out.println("Iniciando exploração para " + dir);

        while (true) {
            int novoX = x;
            int novoY = y;

            if (dir.equals("norte")) novoY++;
            else if (dir.equals("sul")) novoY--;
            else if (dir.equals("leste")) novoX++;
            else if (dir.equals("oeste")) novoX--;
            else {
                System.out.println("Direção inválida.");
                break;
            }

            if (!ambiente.dentroDosLimites(novoX, novoY) || ambiente.temObstaculoEm(novoX, novoY)) {
                System.out.println("Exploração interrompida em (" + novoX + ", " + novoY + ")");
                break;
            }

            mover(novoX - x, novoY - y, ambiente);
            passosDados++;
            x = novoX;
            y = novoY;
        }

        System.out.println("Exploração finalizada. Passos dados: " + passosDados);
    }

    public int getPassosDados() {
        return passosDados;
    }
}

