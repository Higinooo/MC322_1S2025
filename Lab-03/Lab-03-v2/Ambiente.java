import java.util.ArrayList;

public class Ambiente {
    private int largura;
    private int altura;
    private int profundidade;

    private ArrayList<Robo> robosAtivos;
    private ArrayList<Obstaculo> obstaculos;

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

    public void removerRobo(Robo r) { // Remove um robo
        robosAtivos.remove(r);
    }

    public boolean dentroDosLimites(int x, int y) {
        return (x >= 0 && x <= this.largura && y >= 0 && y <= this.altura);
    }

    public boolean dentroDosLimites(int x, int y, int z){ // Para robos aereos
        return (x>=0 && x<=this.largura && y>=0 && y<=this.altura && z >= 0 && z <= this.profundidade);
    }

    public void adicionarObstaculo(Obstaculo obstaculo) {
        this.obstaculos.add(obstaculo);
    }

    public int getResistenciaEm(int x, int y) { // Retorna a resistencia de um obstaculo do ponto x, y
        for (Obstaculo obs : obstaculos) {
            int x1 = obs.getPosicaoX1();
            int x2 = obs.getPosicaoX2();
            int y1 = obs.getPosicaoY1();
            int y2 = obs.getPosicaoY2();
    
            if (x >= x1 && x <= x2 && y >= y1 && y <= y2) {
                int resistencia = obs.getResistencia();
                return resistencia;
            }
        }
        return 0;
    }

    public void removerObstaculo(Obstaculo obstaculo) {
        this.obstaculos.remove(obstaculo);
    }

    public void removerObstaculoEm(int x, int y) {
        for (Obstaculo obs : obstaculos) {
            int x1 = obs.getPosicaoX1();
            int x2 = obs.getPosicaoX2();
            int y1 = obs.getPosicaoY1();
            int y2 = obs.getPosicaoY2();
    
            if (x >= x1 && x <= x2 && y >= y1 && y <= y2) {
                obstaculos.remove(obs);
                System.out.println("Obstáculo removido na posição (" + x + ", " + y + ")");
                return;
            }
        }
    }
    


    public boolean temObstaculoEm(int x, int y) {
        for (Obstaculo obs : obstaculos) {
            int x1 = obs.getPosicaoX1();
            int y1 = obs.getPosicaoY1();
            int x2 = obs.getPosicaoX2();
            int y2 = obs.getPosicaoY2();
    
            // verifica se (x,y) está dentro do retângulo do obstáculo
            if (x >= x1 && x <= x2 && y >= y1 && y <= y2) {
                return true;
            }
        }
        return false;
    }
    

    public void detectarColisoes() {
        for (Robo robo : robosAtivos) {
            int x = robo.getPosX();
            int y = robo.getPosY();
    
            for (Obstaculo obs : obstaculos) {
                int x1 = obs.getPosicaoX1();
                int y1 = obs.getPosicaoY1();
                int x2 = obs.getPosicaoX2();
                int y2 = obs.getPosicaoY2();
    
                if (x >= x1 && x <= x2 && y >= y1 && y <= y2) {
                    System.out.println("Colisão detectada: Robô " + robo.getNome()
                            + " está sobre o obstáculo " + obs.getTipo() + " em (" + x + "," + y + ")");
                }
            }
        }
    }
    

    public int getLargura() {
        return largura;
    }
    
    public int getAltura() {
        return altura;
    }

    public int getProfundidade() {
        return profundidade;
    }

    public ArrayList<Robo> getRobosAtivos() {
        return robosAtivos;
    }
    
    public ArrayList<Obstaculo> getObstaculos(){
        return obstaculos;
    }
}



