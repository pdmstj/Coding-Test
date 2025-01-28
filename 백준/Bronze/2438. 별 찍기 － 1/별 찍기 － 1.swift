import Foundation

if let n = Int(readLine()!) {
    for i in 1...n {
        print(String(repeating: "*", count: i))
    }
}