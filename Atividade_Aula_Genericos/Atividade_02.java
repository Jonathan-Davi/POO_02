public class Atividade_02<T extends Comparable<T>> {

    private T[] elementos;

    public Atividade_02(T[] elementos) {
        this.elementos = elementos;
    }

    public T buscarValor(T valor) {
        for (T elemento : elementos) {
            if (elemento.compareTo(valor) == 0) {
                System.out.println("Valor encontrado: " + elemento);
                return elemento;
            }
        }
        System.out.println("Valor não encontrado.");
        return null;
    }

    public static void main(String[] args) {
        Integer[] numeros = {10, 20, 30, 40, 50};
        Atividade_02<Integer> atividade = new Atividade_02<>(numeros);

        atividade.buscarValor(30);
        atividade.buscarValor(99);
    }
}
