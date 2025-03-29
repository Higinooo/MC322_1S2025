public class RoboTerrestre extends Robo {
    private int velocidadeMaxima;

    public RoboTerrestre(String nome, String direcao, int posicaoX, int posicaoY, int velocidadeMaxima){
        super(nome,direcao,posicaoX,posicaoY);
        this.velocidadeMaxima = velocidadeMaxima; 
    }

    public void mover(int deltaX, int deltaY, Ambiente ambiente, int velocidade){
        if (velocidade <= this.velocidadeMaxima) {
            mover(deltaX,deltaY,ambiente);
        }
        else{
            System.out.println("Velocidade acima da permitida!");
        }
    }



}
