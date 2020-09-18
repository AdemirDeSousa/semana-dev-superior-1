export type RecordsResponse = {
    content: RecordItem[];
    totalPages: number;
}

export type RecordItem = {
    id: number;
    moment: string;
    name: string;
    age: number;
    game_title: string;
    game_platform: Platform;
    genre_name: string;
}

export type Platform = 'XBOX' | 'PC' | 'PLAYSTATION';