//
//  DetailView.swift
//  iosApp
//
//  Created by Tolga Pirim on 19.08.2023.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI
import shared

struct DetailView: View {
    let movie: Movie
    var body: some View {
        ScrollView{
            VStack{
                ZStack{
                    AsyncImage(url: URL(string: movie.imageUrl)){image in
                        image.resizable().scaledToFill()
                    } placeholder: {
                        ProgressView()
                    }
                }.frame(maxWidth: .infinity, minHeight: 300, maxHeight: 300)
                
                VStack(alignment:.leading,spacing: 12){
                    Text(movie.title)
                        .font(.title)
                        .fontWeight(.bold)
                        .fixedSize(horizontal: false, vertical: true)
                    
                    Button(action:{}) {
                        HStack{
                            Image(systemName: "play.fill").foregroundColor(.white)
                            Text("Start watching now").foregroundColor(.white)
                        }
                    }.frame(maxWidth: .infinity, minHeight: 40)
                        .padding(10)
                        .background(.red)
                        .clipShape(RoundedRectangle(cornerRadius: 8))
                    
                    Text("Release Date \(movie.releaseDate)".uppercased())
                        .font(.caption)
                    
                    Text(movie.description_)
                        .font(.body)
                        .fixedSize(horizontal: false, vertical: true)
                    
                }.padding()
                    .background(.black)
                
            }.frame(maxWidth: .infinity, maxHeight: .infinity)
        }
    }
}

struct DetailView_Previews: PreviewProvider {
    static var previews: some View {
        DetailView(movie: Movie(
            id: 1,
            title: "Oppenheimer",
            description: "Oppenheimer Descriptioon",
            imageUrl: "https://pbs.twimg.com/media/FvUVt3hXgAAxP1H?format=jpg&name=900x900",
            releaseDate: "12.12.2023")
        )
    }
}
