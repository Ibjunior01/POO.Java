import java.util.ArrayList;

abstract class Veiculo {
    String placa;
    int ano; 

    public Veiculo (String placa, int ano) {
        this.placa = placa;
        this.ano = ano;
    }

    public abstract double calcValorSeguro ();

    public void mostrarDetalhes () {
        System.out.println( "placa: " + placa + ", Ano: " + ano);
    }    
}

interface Manutencao {
    String realizarManutencao ();
}

class Carro extends Veiculo implements Manutencao {
    private int numeroPortas;

    public Carro (String placa, int ano, int numeroPortas) {
        super (placa, ano);
        this.numeroPortas = numeroPortas; 
    }

    public double calcValorSeguro () {
        return 500 + (50 * numeroPortas);
    }

    public String realizarManutencao () {
        return "Manutencao de carro realizada.";
    }
}

class Moto extends Veiculo implements Manutencao {
    int cilindrada;

    public Moto (String placa, int ano, int cilindrada) {
        super (placa, ano);
        this.cilindrada = cilindrada;
    }

    public double calcValorSeguro () {
        return 200 + (10 * cilindrada);
    }

    public String realizarManutencao () {
        return "Manutencao da moto realizada."; 
    }
}

// import java.util.ArrayList; 

public class GerenciadorVeiculos {
    private ArrayList <Veiculo> veiculos; 

    
    public GerenciadorVeiculos () {
        veiculos = new ArrayList<> ();
    }

    public void adicionarVeiculo (Veiculo veiculo) {
        veiculos.add (veiculo);
    }

    
    public void mostrarDetalhes () {
        for (Veiculo veiculo : veiculos) {
            veiculo.mostrarDetalhes ();
            System.out.println("Valor do seguro: " + veiculo.calcValorSeguro());
            if (veiculo instanceof Manutencao) {
            System.out.println(((Manutencao) veiculo).realizarManutencao());
            }

            System.out.println();
            }
    }

    public static void main (String[] args) {
        GerenciadorVeiculos gerenciador = new GerenciadorVeiculos ();
 
        gerenciador.adicionarVeiculo(new Carro ("ABC-1234", 2020, 4));
        gerenciador.adicionarVeiculo(new Moto ("CBA-4321", 2021, 160));

        gerenciador.mostrarDetalhes();

    }
}

