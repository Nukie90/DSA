public class Dog {
    private String breed;
    private int magicValue;

    public Dog(String n){
        breed = n;
        int v = 0;
        for (int i = 0; i < n.length(); i++)
            v+= n.charAt(i);
        magicValue = v;
    }
    
    @Override
    public String toString() {
        return breed + "(" + magicValue + ")";
    }
    public String getBreed() {
        return breed;
    }
    public int getMagicValue(){
        return magicValue;
    }
    public boolean equals(Object obj){
        Dog other = (Dog) obj;
        if (breed == null){
            if(other.breed != null){
                return false;
            }
        }else if (!breed.equals(other.breed)){
            return false;
        }
        return true;
    }
}
