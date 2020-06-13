package list;
/**
 * @auther: Xudong Zhang
 * @date:2020/6/11
 * ΪTreeSetDemo����ķ���
 */
public class R<T> implements Comparable<T>{
	int count;
	
	public R(int count) {
		this.count = count;
	}
	
	@Override
    public String toString() {
		
		return "R(count����:" + count + ")";
	}
	
    @Override
    public boolean equals(Object obj)
    {
        if (obj instanceof R)
        {
            R r = (R)obj;
            if (r.count == this.count)
            {
                return true;
            }
        }
        return false;
    }
    
    @Override
    public int hashCode()
    {
        return this.count;
    }

	@Override
	public int compareTo(T obj) {
		if (obj instanceof R)
        {
            R r = (R)obj;
            if (r.count == this.count)
            {
                return 0;
            }else if (r.count < this.count) {
				return 1;
			}else {
				return -1;
			}
        }
		return 0;
	}
}
