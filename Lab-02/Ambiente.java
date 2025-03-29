import java.util.ArrayList;
import java.awt.Point;

public class Ambiente {
    private int largura;
    private int altura;
    private int profundidade;

    private ArrayList<Robo> robosAtivos;
    private ArrayList<Point> obstaculos;

    public Ambiente(int largura, int altura, int profundidade){
        this.largura = largura;
        this.altura = altura;
        this.profundidade = profundidade;
        this.robosAtivos = new ArrayList<>();
        this.obstaculos = new ArrayList<>();
    }

    public void adicionarRobo(Robo r) { // Adiciona um robo
        robosAtivos.add(r);
    }

    public void adicionarObstaculo(int x, int y) { // Adiciona um obstaculo em um ponto
        obstaculos.add(new Point(x, y));
    }

    public void removerObstaculo(int x, int y) {
        obstaculos.remove(new Point(x, y));
    }    

    public boolean temObstaculoEm(int x, int y) { // Retorna se ha um obstaculo em um certo ponto
        return obstaculos.contains(new Point(x, y));
    }

    public boolean dentroDosLimites(int x, int y) {
        return (x >= 0 && x <= this.largura && y >= 0 && y <= this.altura);
    }

    public boolean dentroDosLimites(int x, int y, int z){ // Para robos aereos
        return (x>=0 && x<=this.largura && y>=0 && y<=this.altura && z >= 0 && z <= this.profundidade);
    }

    public int getLargura() {
        return largura;
    }
    
    public int getAltura() {
        return altura;
    }
    
}



