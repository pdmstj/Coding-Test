import Foundation

if let testCaseCount = Int(readLine()!) {
    for _ in 0..<testCaseCount {
        if let input = readLine() {
            let numbers = input.split(separator: " ").compactMap { Int($0) }
            if numbers.count == 2 {
                print(numbers[0] + numbers[1])
            }
        }
    }
}