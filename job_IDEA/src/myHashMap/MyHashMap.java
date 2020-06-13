package myHashMap;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * 功能描述:自己实现hashmap的简单功能
 *  get() put()没有考虑扩容的事情
 * @auther: Xudong Zhang
 * @date:   2020/5/15
 */
public class MyHashMap<K,V> {
	
	private int size = 0;
	private static Integer CAMPACITY = 8;
	private Entry[] table;
	
	public MyHashMap() {
		super();
		this.table = new Entry[CAMPACITY];
	}

	public int size() {
		return size;
	}
	
	public  V get(K key) {
		int hash = key.hashCode();
		int index = hash%CAMPACITY;
		for(Entry<K, V> entry = table[index];entry !=null;entry = entry.next) {
			if(entry.k.equals(key)) { 
				return entry.getV();
			}
		}
		return null;
	}
	
	public V put(K key,V value) {
		int hash = key.hashCode();
		int index = hash%CAMPACITY;
		//要是键已经存在，那么新值覆盖老值，返回老值
		for(Entry<K, V> entry = table[index];entry !=null;entry = entry.next) {
			if(entry.k.equals(key)) { 
				V oldValue = entry.v;
				entry.setV(value);;
				//size++;
				return oldValue;
			}
		}
		//不在则添加到链表的开头
		addEntry(key, value, index);
		return null;
	}

	private void addEntry(K key, V value, int index) {
		Entry<K, V> entry = new Entry<K, V>(key, value, table[index]);
		table[index] = entry;
		size++;
	}


	class Entry<K,V>{
		private K k;
		private V v;
		private Entry<K, V> next;

		public Entry(K k, V v, Entry<K, V> next) {
			this.k = k;
			this.v = v;
			this.next = next;
		}

		public void setK(K k) {
			this.k = k;
		}

		public void setV(V v) {
			this.v = v;
		}

		public void setNext(Entry<K, V> next) {
			this.next = next;
		}

		public K getK() {
			return k;
		}

		public V getV() {
			return v;
		}

		public Entry<K, V> getNext() {
			return next;
		}
	}
	
	
	public static void main(String[] args) {
		MyHashMap<String, String> myHashMap = new MyHashMap<String, String>();
		for(int i = 0;i<10;i++) {
			myHashMap.put("JJ"+i, "qwer"+i);			
		}
		System.out.println(myHashMap.get("JJ2"));
		
		System.out.println(myHashMap.size);

		System.out.println(25&8);
	}
}
