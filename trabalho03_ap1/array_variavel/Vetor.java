package array_variavel;

public class Vetor {
  private Integer[] array;
  private int size;
  private int capacity;

  Vetor(int n) {
    this.capacity = n;
    this.size = 0;
    this.array = new Integer[n];
  }

  public void add(Integer i) {
    if (this.capacity == this.size) {
      this.capacity *= 2;
      Integer[] aux = new Integer[this.capacity];
      for (int j = 0; j < this.size; j++) {
        aux[j] = this.array[j];
      }
      this.array = aux;
    }
    this.array[size] = i;
    size++;
  }

  public Integer get(int i) {
    if (i >= 0 && i < this.size)
      return this.array[i];
    return null;
  }

  public int size() {
    return this.size;
  }

  public int capacity() {
    return this.capacity;
  }

  public String toString() {
    String res = "Vetor[";
    for (int i = 0; i < this.size; i++) {
      res += (this.array[i] + " ");
    }
    res += "]";
    return res;
  }

  public boolean equals(Vetor v) {
    if (v == null)
      return false;

    if (this.size != v.size())
      return false;
    
    for (int i = 0; i < this.size; i++) 
      if (this.array[i].equals(v.array[i]))
        return false;
        
    return true;
  }
}
