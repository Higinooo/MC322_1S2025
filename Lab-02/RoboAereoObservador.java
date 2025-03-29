public class RoboAereoObservador extends RoboAereo {
    private int raioObservacao;

    public RoboAereoObservador(String nome, String direcao, int posicaoX, int posicaoY, int altitude, int altitudeMaxima, int raioObservacao) {
        super(nome, direcao, posicaoX, posicaoY, altitude, altitudeMaxima);
        this.raioObservacao = raioObservacao;
    }

    public void observar(Ambiente ambiente) {
        int x = getPosX();
        int y = getPosY();
        boolean encontrou = false;

        for (int i = x - this.raioObservacao; i <= x + this.raioObservacao; i++) {
            for (int j = y - raioObservacao; j <= y + raioObservacao; j++) {
                if (ambiente.dentroDosLimites(i, j) && ambiente.temObstaculoEm(i, j)) {
                    System.out.println("Obstáculo detectado em (" + i + ", " + j + ")");
                    encontrou = true;
                }
            }
        }

        if (!encontrou) {
            System.out.println("Nenhum obstáculo encontrado na área.");
        }
    }
}
