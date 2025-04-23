import java.util.ArrayList;

public class Robo {
    private String nome;
    private String direcao;
    private int posicaoX;
    private int posicaoY;
    private ArrayList<Sensor> sensores;


    public Robo(String nome, String direcao, int posicaoX, int posicaoY){
        this.nome = nome;
        this.posicaoX = posicaoX;
        this.posicaoY = posicaoY;
        this.direcao = direcao;
        this.sensores = new ArrayList<>();
    }
    
    public void mover(int deltaX, int deltaY, Ambiente ambiente) {
        int novaX = this.posicaoX + deltaX;
        int novaY = this.posicaoY + deltaY;
    
        if (novaX >= 0 && novaX <= ambiente.getLargura() &&
            novaY >= 0 && novaY <= ambiente.getAltura()) {
            
            this.posicaoX = novaX;
            this.posicaoY = novaY;
        } else {
            System.out.println("Movimento inválido: fora dos limites do ambiente.");
        }
    }
    
    public void exibirPosicao(){
        System.out.println("Posição: X = " + this.posicaoX + ", Y = " + this.posicaoY);
    }

    public void identificarObstaculo(Ambiente ambiente) {
        int x = this.getPosX();
        int y = this.getPosY();
    
        boolean encontrou = false;
    
        // Cima
        if (ambiente.temObstaculoEm(x, y + 1)) {
            System.out.println("Obstáculo acima.");
            encontrou = true;
        }
    
        // Baixo
        if (ambiente.temObstaculoEm(x, y - 1)) {
            System.out.println("Obstáculo abaixo.");
            encontrou = true;
        }
    
        // Direita
        if (ambiente.temObstaculoEm(x + 1, y)) {
            System.out.println("Obstáculo à direita.");
            encontrou = true;
        }
    
        // Esquerda
        if (ambiente.temObstaculoEm(x - 1, y)) {
            System.out.println("Obstáculo à esquerda.");
            encontrou = true;
        }
    
        if (!encontrou) {
            System.out.println("Nenhum obstáculo ao redor.");
        }
    }
    

    public int getPosX(){
        return this.posicaoX;
    }

    public int getPosY(){
        return this.posicaoY;
    }

    public String getDirecao() {
        return this.direcao;
    }

    public String getNome() {
        return this.nome;
    }
    
    public void adicionarSensor(Sensor s) {
        sensores.add(s);
    }
    
    public void ativarSensores(Ambiente ambiente) {
        int x = getPosX();
        int y = getPosY();
        int z = 0;
    
        if (this instanceof RoboAereo) {
            z = ((RoboAereo) this).getAltitude();
        }
    
        for (Sensor s : sensores) {
            s.monitorar(ambiente, x, y, z);
        }
    }
    
}
