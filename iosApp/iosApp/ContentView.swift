import SwiftUI
import UIKit
import shared

struct ComposeView: UIViewControllerRepresentable {
    func updateUIViewController(_ uiViewController: UIViewControllerType, context: Context) {
        
    }
    
    func makeUIViewController(context: Context) -> some UIViewController {
        Home_iosKt.MainViewController()
    }
}

struct ContentView: View {

	var body: some View {
		ComposeView()
	}
}

