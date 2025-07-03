public class Atividade_01{
    
    public  <T extends Comparable<T>> T maiorValor(T[] array) {
        T maior = array[0];
        for (T elemento : array) {
            if (elemento.compareTo(maior) > 0) {
                maior = elemento;
            }
        }
        return maior;
    }

    public static void main(String[] args) {
        Atividade_01 atividade = new Atividade_01();

        Integer[] numeros = {10, 22, 13, 44, 15};

        System.out.println("Maior número: " + atividade.maiorValor(numeros));
    }
}

