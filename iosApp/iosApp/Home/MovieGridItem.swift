//
//  MovieGridItem.swift
//  iosApp
//
//  Created by Tolga Pirim on 19.08.2023.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI
import shared

struct MovieGridItem: View {
    let movie: Movie
    var body: some View {
        VStack(alignment: .leading, spacing: 8){
            ZStack{
                AsyncImage(url: URL(string: movie.imageUrl)){image in
                    image.resizable()
                } placeholder: {
                    Color.gray
                }
                
                Circle()
                    .frame(width: 50,height: 50)
                    .foregroundColor(.black.opacity(0.7))
                
                Image(systemName: "play.fill").foregroundColor(.white)
            }.frame(maxWidth: .infinity)
                .clipShape(RoundedRectangle(cornerRadius: 8))
            
            Text(movie.title)
                .font(.title3)
                .lineLimit(1)
            
            Text(movie.releaseDate)
                .font(.caption)
        }.frame(maxWidth: .infinity,maxHeight: 260)
    }
}

struct MovieGridItem_Previews: PreviewProvider {
    static var previews: some View {
        MovieGridItem(movie: Movie(
            id: 1,
            title: "Oppenheimer",
            description: "Oppenheimer Descriptioon",
            imageUrl: "https://pbs.twimg.com/media/FvUVt3hXgAAxP1H?format=jpg&name=900x900",
            releaseDate: "12.12.2023")
        )
    }
}
