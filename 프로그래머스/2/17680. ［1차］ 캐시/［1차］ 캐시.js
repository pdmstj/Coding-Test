function solution(cacheSize, cities) {
    let executionTime = 0;
    let cache = [];
    
    cities.forEach(city => {
        city = city.toLowerCase();
        
        let index = cache.indexOf(city);
        
        if (index !== -1) {
            cache.splice(index, 1);
            cache.push(city);
            executionTime += 1; 
        } else {
            if (cacheSize > 0 && cache.length === cacheSize) {
                cache.shift();
            }
            if (cacheSize > 0) {
                cache.push(city);
            }
          executionTime += 5;
        }   
    });
    
    return executionTime;
}
