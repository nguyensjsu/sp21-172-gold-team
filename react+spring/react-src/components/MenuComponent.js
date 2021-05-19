import React from 'react';
import MenuService from '../services/MenuService';

class MenuComponent extends React.Component {

    constructor(props){
        super(props)
        this.state = {
            menu:[]
        }
    }
    
    componentDidMount(){
        MenuService.getMenu().then((response) => {
            this.setState({ menu: response.data})
        });
    }
    
    render(){
        return (
            <div>
                <h1 className = "text-center"> Menu </h1>
                <table className = "table table-striped" >
                    <thread>
                        <tr>
                            <td>StarbucksOrder Id</td>
                            <td>StarbucksOrder Drink</td>
                            <td>StarbucksOrder Size</td>
                            <td>StarbucksOrder Price</td>
                        </tr>
                    </thread>
                    <tbody>
                        {
                            this.state.menu.map(
                                menu =>
                                <tr key = {menu.id}>
                                    <td>{menu.id}</td>
                                    <td>{menu.drink}</td>
                                    <td>{menu.size}</td>
                                    <td>{menu.price}</td>
                                </tr>)
                            
                        }
                    </tbody>

                </table>

            </div>
        )
    }
}
export default MenuComponent