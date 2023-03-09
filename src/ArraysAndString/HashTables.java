package ArraysAndString;


public class HashTables<K,V>{

    Node<K,V>[] heads;

    public HashTables(){
        heads = new Node[5];
    }

    public void put(K key, V value){
        // 1. compute the key's hash code
        int hash = Math.abs(key.hashCode());
        
        // 2. map the hash code to an index in the array
        int idx = hash % heads.length;
        if(heads[idx] ==null){
            heads[idx] = new Node<>(key, value);
        }else{
            Node<K,V> node= heads[idx];
            while(!node.key.equals(key) &&  node.next!=null){
                node = node.next;
            }
            if(node.key.equals(key)){
                node.value = value;
                return;
            }
            node.next = new Node<>(key, value);
        }
    }

    public V get(K key){
        int hash = Math.abs(key.hashCode());
        int idx = hash % heads.length;
        Node<K,V> node = heads[idx];
        while(node != null&&!node.key.equals(key) ){
            node = node.next;
        }
        if(node ==null){
            return null;
        }
        return node.value;
    }



    static class Node<K,V>{
        Node<K,V> next;
        K key;
        V value;

        public Node(K key, V value){
            this.key = key;
            this.value = value;
        }
    }
}

class Main{
    public static void main(String[] args) {
        HashTables<String, String> hashTables = new HashTables<>();
        hashTables.put("firstKey", "firstValue");
        hashTables.put("secondKey", "secondVBlau");
        System.out.println(hashTables.get("firstKey"));
        System.out.println(hashTables.get("secondKey"));
        System.out.println(hashTables.get("notExist"));
        hashTables.put("firstKey", "changedVal");
        System.out.println(hashTables.get("firstKey"));
    }
}