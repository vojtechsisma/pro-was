//vytvoreni hraciho pole
const table = document.createElement('table')

for (let index = 1; index <= 49; ) {
    const tr = document.createElement('tr')
    for (let i = 0; i < 7 && index <= 49; i++) {
        const td = document.createElement('td')
        td.dataset.id = index - 1
        tr.appendChild(td)
        index++
    }
    table.appendChild(tr)
}

document.querySelector('.game').appendChild(table)

//init variables
let currentPlayer = 'O'
let array = [
    ['', '', '', '', '', '', ''],
    ['', '', '', '', '', '', ''],
    ['', '', '', '', '', '', ''],
    ['', '', '', '', '', '', ''],
    ['', '', '', '', '', '', ''],
    ['', '', '', '', '', '', ''],
    ['', '', '', '', '', '', ''],
]
let cells = document.querySelectorAll('td')
let win = false
let scoreX = 0
let scoreO = 0
let actual = document.querySelector('#actual')
actual.innerText = 'O'

const check = () => {}

//action po kliknuti na bunku
const cellClicked = (e) => {
    actual.innerText = currentPlayer
    e.target.innerText = currentPlayer
    const row = Math.floor(parseInt(e.target.dataset.id) / 7)
    const column = Math.floor(parseInt(e.target.dataset.id) % 7)
    array[row][column] = currentPlayer
    console.log(array)
    currentPlayer == 'X' ? (currentPlayer = 'O') : (currentPlayer = 'X')
    e.target.removeEventListener('click', cellClicked)
    check()
}

const start = () => {
    for (const cell of cells) {
        cell.addEventListener('click', cellClicked)
    }
}

start()

//reset hraciho pole
const clear = () => {
    currentPlayer = 'O'
    actual.innerText = 'O'
    array = [
        ['', '', '', '', '', '', ''],
        ['', '', '', '', '', '', ''],
        ['', '', '', '', '', '', ''],
        ['', '', '', '', '', '', ''],
        ['', '', '', '', '', '', ''],
        ['', '', '', '', '', '', ''],
        ['', '', '', '', '', '', ''],
    ]
    win = false
    for (const cell of cells) {
        cell.innerText = ''
    }
    start()
}

document.querySelector('#reset').addEventListener('click', clear)

//vstup jmen
const p1 = document.querySelector('input[name="player1"]')
const p2 = document.querySelector('input[name="player2"]')

p1.addEventListener('keyup', (e) => {
    document.querySelector('#p1').innerText = e.target.value
})

p2.addEventListener('keyup', (e) => {
    document.querySelector('#p2').innerText = e.target.value
})
