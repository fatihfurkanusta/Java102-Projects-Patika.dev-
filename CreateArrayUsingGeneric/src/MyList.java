class MyList<T>{
    int capacity;
    T[] list;
    T[] listTemp;
    int dimensionSize = 0;

    public void setList(){
        this.list =(T[]) new Object[this.capacity];
    }

    public void increaseCapasity(){
        this.listTemp = (T[]) new Object[this.capacity];
        for (int i = 0;i< this.list.length;i++){
            this.listTemp[i] = this.list[i];
        }
        this.list=this.listTemp;
    }
    public MyList(int capacity){
        this.capacity=capacity;
        this.setList();
    }

    //Kapasite Belirledik.
    public MyList(){
        this.capacity =10;
        this.setList();
    }
    // Dizideki kapasite değerini verir.
    public int getCapacity() {
        return capacity;
    }
    //Dizideki eleman sayısını verir.
    public  int size(){
        return this.dimensionSize;
    }
    public void sizeCalc(){
        int count = 0;
        for (int i = 0; i<this.list.length;i++){
            if (this.list[i]!= null){
                count++;
            }
        }
        this.dimensionSize  = count;
    }
    //Eğer kapasite uzunluktan büyükse değişiklik yapma değilse kapasiteyi iki katına çıkart.
    public void add (T data){
        if (this.size()<this.capacity){
            list[this.dimensionSize]=data;
            this.sizeCalc();
        }else {
            this.capacity = this.capacity*2;
            this.increaseCapasity();
            this.add(data);
        }
    }

    public T get(int index){
        return list[index];
    }
    public void remove(int index){
        T[] listTepm2 = this.list;
        this.list[index] = null;
        for(int i=index; i <list.length;i++){
            list[index] = list[index+1];
        }
    }


}