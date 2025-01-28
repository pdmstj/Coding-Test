import Foundation

if let testCaseCount = Int(readLine()!) {
    for i in 1...testCaseCount {
        if let input = readLine() {
            let numbers = input.split(separator: " ").compactMap { Int($0) }
            if numbers.count == 2 {
                let a = numbers[0]
                let b = numbers[1]
                print("Case #\(i): \(a + b)")
            }
        }
    }
}
