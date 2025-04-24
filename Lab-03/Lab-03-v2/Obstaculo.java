public class Obstaculo {
    private int posicaoX1;
    private int posicaoY1;
    private int posicaoX2;
    private int posicaoY2;
    private TipoObstaculo tipo;

    public Obstaculo(int posicaoX1, int posicaoY1, int posicaoX2, int posicaoY2, TipoObstaculo  tipo){
        this.posicaoX1 = posicaoX1;
        this.posicaoY1 = posicaoY1;
        this.posicaoX2 = posicaoX2;
        this.posicaoY2 = posicaoY2;
        this.tipo = tipo;
    }

    public int getAltura() {
        return this.tipo.getAlturaPadrao();
    }

    public TipoObstaculo getTipo(){
        return this.tipo;
    }
    public int getResistencia(){
        return tipo.getResistenciaTipo();
    }
    
    public int getPosicaoX1() {
        return this.posicaoX1;
    }

    public int getPosicaoX2() {
        return this.posicaoX2;
    }

    public int getPosicaoY1() {
        return this.posicaoY1;
    }

    public int getPosicaoY2() {
        return this.posicaoY2;
    }
    
}
