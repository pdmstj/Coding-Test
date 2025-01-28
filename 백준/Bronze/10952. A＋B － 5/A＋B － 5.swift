import Foundation

while true {
    guard let input = readLine() else { break }
    
    let numbers = input.split(separator: " ").compactMap { Int($0) }
    if numbers == [0, 0] {
        break
    }
    if numbers.count == 2 {
        print(numbers[0] + numbers[1])
    }
}
