// Robo que consegue destruir um obstáculo ao redor dele
public class RoboTerrestreDestruidor extends RoboTerrestre {
    private int forcaDestruicao; //forca da destruicao, dependendo da resistencia do obstaculo (sera implementado)

    public RoboTerrestreDestruidor(String nome, String direcao, int posicaoX, int posicaoY, int velocidadeMaxima, int forcaDestruicao) {
        super(nome, direcao, posicaoX, posicaoY, velocidadeMaxima);
        this.forcaDestruicao = forcaDestruicao;
    }

    public void destruirObstaculo(Ambiente ambiente) {
        int x = this.getPosX();
        int y = this.getPosY();
                
        if (ambiente.temObstaculoEm(x + 1, y)) {
            System.out.println("Obstáculo à direita. Destruindo com forca " + forcaDestruicao);
            ambiente.removerObstaculo(x + 1, y);

        } else if (ambiente.temObstaculoEm(x - 1, y)) {
            System.out.println("Obstáculo à esquerda. Destruindo com forca " + forcaDestruicao);
            ambiente.removerObstaculo(x - 1, y);

        } else if (ambiente.temObstaculoEm(x, y + 1)) {
            System.out.println("Obstáculo acima. Destruindo com forca " + forcaDestruicao);
            ambiente.removerObstaculo(x, y + 1);

        } else if (ambiente.temObstaculoEm(x, y - 1)) {
            System.out.println("Obstáculo abaixo. Destruindo com forca " + forcaDestruicao);
            ambiente.removerObstaculo(x, y - 1);

        } else {
            System.out.println("Nenhum obstáculo ao redor para destruir.");
        }
    }
    
}
