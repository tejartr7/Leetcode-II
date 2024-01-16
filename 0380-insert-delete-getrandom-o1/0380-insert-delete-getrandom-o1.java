class RandomizedSet {
 Set<Integer> nm=new HashSet<>();
    public RandomizedSet() {
        
    }
    
    public boolean insert(int v) {
        if(nm.contains(v))
        {
            return false;
        }
        else
        {
           nm.add(v);
            return true;
        }
    }
    
    public boolean remove(int v) {
        if(nm.contains(v))
        {
            nm.remove(v);
            return true;
        }
        else 
        {
            return false;
        }
    }
    
    public int getRandom() {
        List<Integer> b = new ArrayList<Integer>(nm);
        int s=(int)(Math.random()*(b.size()-0))+0;
        return b.get(s);
    }
}