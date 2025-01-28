import Foundation

if let totalAmount = Int(readLine()!) {
    if let itemCount = Int(readLine()!) {
        var calculatedTotal = 0
        for _ in 0..<itemCount {
            if let input = readLine() {
                let parts = input.split(separator: " ").compactMap { Int($0) }
                if parts.count == 2 {
                    let price = parts[0]
                    let quantity = parts[1]
                    calculatedTotal += price * quantity
                }
            }
        }
        print(calculatedTotal == totalAmount ? "Yes" : "No")
    }
}
