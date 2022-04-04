public class fila {
    private Integer[] dado;
    private int tamMax;
    private Integer[] ordem;
    private int tamanho;

    public fila(int tamMax){
        this.tamMax = tamMax;
        this.dado = new Integer[tamMax];
        this.ordem = new Integer[tamMax];
        this.tamanho = 0;
    }
    public void add(Integer n){
        if(!cheio() && n != null){
            for(int i = 0; i < this.dado.length; i++){
                if(this.dado[i] == null){ // primeiro espaco que estiver vazio ja entra
                    this.dado[i] = n;
                    this.ordem[tamanho] = i;
                    i = this.dado.length;
                }
            }
            this.tamanho++;
        }
    }
    public void remove(){remove(1);}
    public void remove(int qntd){
        if(vazio() || this.tamanho >= qntd){
            for(int i = 0; i < qntd; i++){
                this.dado[ordem[i]] = null;
                this.tamanho--;
                ajusteOrdem();
            }
        }
    }
    private boolean vazio(){
        if(this.tamanho == 0){
            System.out.println("O array ja esta vazio");
            return true;
        }else{
            return false;
        }
    }
    private boolean cheio(){
        if(this.tamanho == this.tamMax){
            System.out.println("O array ja esta cheio");
            return true;
        }else{
            return false;
        }
    }
    public fila merge(fila fila_para_concatenar){ 
        return merge(fila_para_concatenar, false);
    }
    public fila merge(fila fila_para_concatenar, boolean ordenar){ // retorna uma nova fila
        fila nova_fila = new fila(this.tamMax + fila_para_concatenar.getTamMax());
        for(int i = 0; i < this.tamMax; i++){
            nova_fila.add(this.dado[i]);
        }
        for(int i = 0; i < fila_para_concatenar.getTamMax(); i++){
            nova_fila.add(fila_para_concatenar.get(i));
        }
        if(ordenar){
            nova_fila.ordenar();
        }
        return nova_fila;
    }
    public void ordenar(){ // ordena e reseta a ordem de remocao/adicao
        if(!vazio()){
            int aTrocar;
            for(int i = 1; i < this.tamanho; i++){
                if(this.dado[i-1] > this.dado[i]){
                    aTrocar = this.dado[i-1];
                    this.dado[i-1] = this.dado[i];
                    this.dado[i] = aTrocar;
                    if(i-1 > 0 && (this.dado[i-2] > this.dado[i-1])){
                        i = i -2;
                    }
                }
            } 
            resetOrdem();          
        }
    }
    
    private void resetOrdem(){
        for(int i = 0; i < this.ordem.length; i++){ // reset da ordem
            if(this.ordem[i] != null){
                this.ordem[i] = i;
            }
        } 
    }

    public int ultimo(){
        return dado[ordem[ordem.length-1]];
    }
    public int primeiro(){
        return dado[ordem[0]];
    }
    public Integer get(int index){
        return this.dado[index];
    }
    public int getTamMax(){return this.tamMax;}
    public void println(){
        System.out.print("[");
        for(int i = 0; i < this.tamanho; i++){
            if(this.dado[ordem[i]] != null){
                if(i != 0){
                    System.out.print(", ");
                }
                System.out.print(this.dado[i]);
            }
        }
        System.out.println("]");
    }
    private void ajusteOrdem(){
        for(int i = 0; i < tamanho+1; i++){
            if(i == tamanho){
                ordem[i] = null;
            }else{
                ordem[i] = ordem[i+1];   
            }
        }
    }
}
