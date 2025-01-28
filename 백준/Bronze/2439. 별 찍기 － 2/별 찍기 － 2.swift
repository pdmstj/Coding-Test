import Foundation

if let n = Int(readLine()!) {
    for i in 1...n {
        let spaces = String(repeating: " ", count: n - i)
        let stars = String(repeating: "*", count: i)
        print(spaces + stars)
    }
}