class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        HashMap<String, Integer> result = new HashMap<>();
        for(String cpd : cpdomains) {
            //将字符分为计数和域名字符串
            String[] ele = cpd.split(" ");
            int count = Integer.valueOf(ele[0]);
            String temp = null;
            String name = ele[1];

            //处理每个子域名并将前后计数和放入hashmap中
            while(name != null) {
                if(result.containsKey(name)) {
                    int n = result.get(name);
                    result.replace(name, n, n + count);
                } else {
                    result.put(name, count);
                }
                int position = name.indexOf(".");
                System.out.println(name);
                if(position == -1) {
                    name = null;
                } else {
                    name = name.substring(position + 1);
                }
            }
            //System.out.println(count);
            //System.out.println(ele[1]);
        }
        List<String> ans = new ArrayList<>();
        for (String key : result.keySet()) {
          //System.out.println("key= " + key + " and value= " + result.get(key));
          ans.add(result.get(key).toString() + " " + key);
      }
        return ans;
    }
}