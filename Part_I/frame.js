'use strict'

const readline = require('readline');

const frameText = (text) => {
    const words = text.trim().split(' ');
    const longestWord = words.reduce((longest, word) => word.length > longest.length ? word : longest);
    const framedWords = words.map(word => (
        `* ${word.padEnd(longestWord.length, ' ')} *`
    ));
    const horizontalFrame = ''.padEnd(longestWord.length + 4, '*');
    framedWords.unshift(horizontalFrame);
    framedWords.push(horizontalFrame);
    
    return framedWords.join('\n');
};


if(process.argv.length > 2) {
    console.log(frameText(process.argv[2]));
} else {
    const rl = readline.createInterface({
        input: process.stdin,
        output: process.stdout
    });

    rl.question('Write something to be framed: ', value => {
        console.log(frameText(value));
        rl.close();
    });
}

