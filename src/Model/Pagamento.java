package Model;

public class Pagamento {

    // ATRIBULTOS
    private String nome;
    private String cpf;
    private String cargo;
    private double valorHora;
    private int quantidadeHoras;
    private double horasExtras50;
    private double horasExtras100;
    private int dependentes;
    private double tipoInsalubridade;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public double getValorHora() {
        return valorHora;
    }

    public void setValorHora(double valorHora) {
        this.valorHora = valorHora;
    }

    public int getQuantidadeHoras() {
        return quantidadeHoras;
    }

    public void setQuantidadeHoras(int quantidadeHoras) {
        this.quantidadeHoras = quantidadeHoras;
    }

    public double getHorasExtras50() {
        return horasExtras50;
    }

    public void setHorasExtras50(double horasExtras50) {
        this.horasExtras50 = horasExtras50;
    }

    public double getHorasExtras100() {
        return horasExtras100;
    }

    public void setHorasExtras100(double horasExtras100) {
        this.horasExtras100 = horasExtras100;
    }

    public int getDependentes() {
        return dependentes;
    }

    public void setDependentes(int dependentes) {
        this.dependentes = dependentes;
    }

    public double getTipoInsalubridade() {
        return tipoInsalubridade;
    }

    public void setTipoInsalubridade(double tipoInsalubridade) {
        this.tipoInsalubridade = tipoInsalubridade;
    }

    // MÉTODOS ABAIXO. 
    public double calcularSalarioBruto() {
        return this.valorHora * this.quantidadeHoras;
    }

    public double calcularVale() {
        return this.calcularSalarioBruto() * 0.06; //calcular os 6% do salario bruto
    }

    public double calcularValeTransporte(double valorTransporteMensal) { //calcular o vale transporte 
        if (this.calcularVale() > valorTransporteMensal) {
            return 0;
        } else {
            return this.calcularVale();
        }
    }

    public double calcularSalarioFamilia() {
        double salario = this.calcularSalarioBruto();
        if (salario <= 907.77) {
            return this.dependentes * 46.54;
        } else if (salario >= 907.78 && salario <= 1364.43) {
            return this.dependentes * 32.80;
        } else if (salario > 1364.44) {
            return 0;
        } else {
            return 0;
        }
    }

    public double calcularInsalubridade() { 
        switch ((int) tipoInsalubridade) {
            case 1:
                return 0;
            case 2:
                return 997.00 * 0.1;
            case 3:
                return 997.00 * 0.2;
            case 4:
                return 997.00 * 0.4;
            default:
                return 0;
        }
    }

    public double calcularInss() {
        double salario = this.calcularSalarioBruto();
        if (salario <= 1751.81) {
            return salario * 0.08;
        } else if (salario >= 1751.82 && salario <= 2919.72) {
            return salario * 0.09;
        } else if (salario >= 2919.73 && salario <= 5839.45) {
            return salario * 0.11;
        } else if (salario > 5839.45) {
            return salario * 0.27;
        } else {
            return 0;
        }
    }

    public double calcularValeRefeicao(double valorVale) { 
        double valeRefeicao = (25 * valorVale) * 0.2;
        return valeRefeicao;
    }

    public double calcularValorExtra50() {
        return (this.valorHora * this.horasExtras50 * 1.50);
    }

    public double calcularValorExtra100() {
        return (this.valorHora * this.horasExtras100 * 2);
    }

    public double calcularTotalHorasExtras() {
        return this.calcularValorExtra50() + this.calcularValorExtra100();
    }

    public double calcularSalarioLiquido() {
        return (this.calcularSalarioBruto() + this.calcularInsalubridade() + this.calcularSalarioFamilia() - this.calcularInss() + this.calcularTotalHorasExtras() - this.calcularValeTransporte(valorHora) - this.calcularValeRefeicao(valorHora));
    }

    @Override
    public String toString() {
        return "\nNome: " + nome
                + "\nCPF: " + cpf
                + "\nSalário bruto: " + calcularSalarioBruto()
                + "\nINSS: " + calcularInss()
                + "\nSalário familia: " + calcularSalarioFamilia()
                + "\nTotal de horas extras:" + calcularTotalHorasExtras()
                + "\nVale refeição: " + calcularValeRefeicao(valorHora)
                + "\nVale transporte: " + calcularValeTransporte(valorHora)
                + "\nInsalubridade: " + calcularInsalubridade();
    }

}
