import axios from 'axios'

const MENU_REST_API_URL = 'http://localhost:8080/api/users';

class MenuService {
    getMenu(){
        return axios.get(MENU_REST_API_URL);
    }
}

export default new MenuService();

