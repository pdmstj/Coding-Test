import Foundation

if let n = Int(readLine()!), let input = readLine() {
    let numbers = input.split(separator: " ").compactMap { Int($0) }
    if let minValue = numbers.min(), let maxValue = numbers.max() {
        print("\(minValue) \(maxValue)")
    }
}
