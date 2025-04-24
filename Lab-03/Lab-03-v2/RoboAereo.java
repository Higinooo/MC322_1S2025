public class RoboAereo extends Robo{
    private int altitude;
    private int altitudeMaxima;

    public RoboAereo(String nome, String direcao, int posicaoX, int posicaoY, int altitude, int altitudeMaxima){
        super(nome,direcao,posicaoX,posicaoY);
        this.altitude = altitude;
        this.altitudeMaxima = altitudeMaxima;
    }

    public void subir(int metros){
        if (this.altitude + metros <= this.altitudeMaxima){
            this.altitude = this.altitude + metros;
        }
        else{
            System.out.println("Altura acima da permitida!");
        }
    }

    public void descer(int metros){
        if (this.altitude - metros >= 0){
            this.altitude = this.altitude - metros;
        }
        else{
            System.out.println("Altura abaixo da permitida!");
        }
    }

    public void exibirPosicaoAereo(){
        System.out.println("Posição: X = " + getPosX() + ", Y = " + getPosY() + ", Z = " + this.altitude);
    }

    public int getAltitude() {
        return this.altitude;
    }    
}
