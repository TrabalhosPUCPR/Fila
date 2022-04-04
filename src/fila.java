
public class fila {
    private Integer[] dado;
    private int tamMax;
    private Integer primeiro;
    private Integer ultimo;
    private int tamanho;

    public fila(int tamMax){
        this.tamMax = tamMax;
        this.dado = new Integer[tamMax];
        //this.ordem = new Integer[tamMax]; eu queria poder fazer assim :(
        this.primeiro = 0;
        this.ultimo = -1;
        this.tamanho = 0;
    }
    public void add(Integer n){
        if(!cheio()){
            if(this.ultimo == this.tamMax - 1){
                this.ultimo = 0;
                this.dado[0] = n;
            }else{
                this.ultimo++;
                this.dado[this.ultimo] = n;
            }
        }
        this.tamanho++;
    }
    public void remove(){
        if(!vazio()){
            if(this.primeiro == this.tamMax - 1){
                this.primeiro = 0;
                this.dado[0] = null;
            }else{
                this.dado[this.primeiro] = null;
                this.primeiro += 1;
            }
            this.tamanho--;
        }
    }
    private boolean vazio(){
        if(this.primeiro == this.ultimo){return true;}
        return false;
    }
    private boolean cheio(){
        if((this.ultimo + 1 == this.primeiro && this.ultimo != -1) || (this.ultimo + 1 == this.tamMax && this.primeiro == 0)){
            return true;
        }
        return false;
    }
    public fila merge(fila fila_para_concatenar){ // retorna uma nova fila
        fila nova_fila = new fila(this.tamMax + fila_para_concatenar.tamMax);
        for(Integer p = this.primeiro; this.ultimo+1 > p; p++){
            nova_fila.add(this.dado[p]);
        }
        for(Integer p = fila_para_concatenar.primeiro; fila_para_concatenar.ultimo+1 > p; p++){
            nova_fila.add(fila_para_concatenar.dado[p]);
        }
        nova_fila.ordenar();
        return nova_fila;
    }
    public void ordenar(){ // ordena e reseta a ordem de remocao/adicao
        if(!vazio() || tamanho == 1){
            Integer aTrocar;
            Integer p = this.primeiro;
            for(int cont = 1; this.tamanho > cont; p++, cont++){
                if(this.dado[p+1] == null || this.dado[p+1] < this.dado[p]){
                    aTrocar = this.dado[p];
                    this.dado[p] = this.dado[p+1];
                    this.dado[p+1] = aTrocar;
                    if(p > 0 && this.dado[p] != null && this.dado[p-1] != null && this.dado[p] < this.dado[p-1]){
                        p -= 2;
                        cont -= 2;
                    }
                }
                if(p+3 > this.tamMax){p = -1; cont = 0;}
            }
            this.primeiro = 0;
            this.ultimo = p;      
        }
    }
    public int getUltimo(){
        return this.dado[this.ultimo];
    }
    public int primeiro(){
        return this.dado[this.primeiro];
    }
    public void println(){
        int p = this.primeiro;
        int cont = 0;
        System.out.print("[");
        while(cont <= tamanho){
            if(p > this.tamanho){
                p = 0;
            }
            if(this.dado[p] != null){
                System.out.print(this.dado[p]);
                System.out.print(", ");
            }
            cont++;
            p++;
        }
        System.out.println("]");
    }
}