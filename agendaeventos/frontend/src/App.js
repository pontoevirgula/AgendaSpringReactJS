import React, { Component } from 'react';
import './App.css';

class App extends Component {

    constructor(props){
        super(props);
        this.state={
            title: 'Agenda de Eventos',
            act: 0,
            index: '',
            datas : [
                {id:1,nome:"Workshop ReactJs",descricao:"Estudar framework para front",datainicio:"25/10/2018 19:00",datafim:"26/10/2018 23:59"},
                {id:2,nome:"Workshop Spring Data",descricao:"Adicionar MongoDB no projeto",datainicio:"27/10/2018 19:00",datafim:"28/10/2018 23:59"},
                {id:3,nome:"Desenvolvimento mobile Ionic",descricao:"Entrar no mundo híbrido",datainicio:"29/10/2018 19:00",datafim:"28/11/2018 23:59"}
            ],
        }
    }

    componentDidMount(){
        this.refs.nome.focus();
    }

    fSubmit = (e) =>{
        e.preventDefault();
        console.log('try');

        let datas = this.state.datas;
        let nome = this.refs.nome.value;
        let descricao = this.refs.descricao.value;
        let datainicio = this.refs.datainicio.value;
        let datafim = this.refs.datafim.value;

        if(this.state.act === 0){   //new
            let data = {
                nome, descricao, datainicio,datafim
            }
            datas.push(data);
        }else{                      //update
            let index = this.state.index;
            datas[index].nome = nome;
            datas[index].descricao = descricao;
            datas[index].datainicio = datainicio;
            datas[index].datafim = datafim;
        }

        this.setState({
            datas: datas,
            act: 0
        });

        this.refs.myForm.reset();
        this.refs.nome.focus();
    }

    fRemove = (i) => {
        let datas = this.state.datas;
        datas.splice(i,1);
        this.setState({
            datas: datas
        });

        this.refs.myForm.reset();
        this.refs.nome.focus();
    }

    fEdit = (i) => {
        let data = this.state.datas[i];
        this.refs.nome.value = data.nome;
        this.refs.descricao.value = data.descricao;
        this.refs.datainicio.value = data.datainicio;
        this.refs.datafim.value = data.datafim;

        this.setState({
            act: 1,
            index: i
        });

        this.refs.nome.focus();
    }

    render() {
        let datas = this.state.datas;
        return (

            <div className="App">
            <h2>{this.state.title}</h2>

        <form ref="myForm" className="myForm">
            <input type="text" ref="nome" placeholder="Nome do evento" className="formField" />
            <input type="text" ref="descricao" placeholder="Descrição do evento" className="formField" />
            <input type="text" ref="datainicio" placeholder="data e hora de inicio no formato: xx/xx/xxxx xx:xx" className="formField" />
            <input type="text" ref="datafim" placeholder="data e hora de término no formato: xx/xx/xxxx xx:xx" className="formField" />
            <button onClick={(e)=>this.fSubmit(e)} className="myButton">Salvar evento </button>
        </form>

            <table class="table table-stripe">
            <thead>
                <tr>
                    <th>Nome</th>
                    <th>Descrição</th>
                    <th>Data de Início</th>
                    <th>Data de Término</th>
                    <th></th>
                </tr>
            </thead>

            <tbody>


            {datas.map((data, i) =>
                <tr key={i} className="myList">
                    <td>{data.nome}</td>
                    <td>{data.descricao}</td>
                    <td>{data.datainicio}</td>
                    <td>{data.datafim}</td>
                    <td> <button onClick={()=>this.fRemove(i)} className="myListButton">Remover </button> </td>
                    <td> <button onClick={()=>this.fEdit(i)} className="myListButton">Editar </button> </td>
                </tr>

            )}



        </tbody>
        </table>
        </div>

    );
    }
}

export default App;