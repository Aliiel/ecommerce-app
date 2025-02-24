import { useState } from "react";
import { Menu, MenuButton, MenuItem, MenuItems } from "@headlessui/react";
import { ShoppingCartIcon } from '@heroicons/react/24/outline';
import { UserIcon } from "@heroicons/react/24/outline";
import { Link } from "react-router";

function Header() {
    const [isAuthenticated, setIsAuthenticated] = useState(false); 
  
    return (
      <header className="bg-purple-200 p-4 flex justify-between items-center shadow-md">
        <Link to="/" >
        <div className="flex items-center space-x-3">
          <img src="/assets/—Pngtree—purple life tree_17336984.png" alt="Logo" className="h-15" />
          <h1 className="text-xl font-bold">Cire & Sérénité</h1>
        </div>
        </Link>
  
        {/* Menu selon l'état de connexion */}
        <div>
          {isAuthenticated ? (
            <Menu as="div" className="relative inline-block text-left">
            <MenuButton>
            <ShoppingCartIcon className="h-8 w-8 text-gray-800" />
          </MenuButton>
                <MenuItems className="absolute right-0 mt-2 w-48 bg-white border rounded-md shadow-lg">
                  <MenuItem>
                    <Link to="/cart" className="block px-4 py-2 text-sm text-gray-700 hover:bg-gray-100">
                      Mon panier
                    </Link>
                  </MenuItem>
                  </MenuItems>
          </Menu>
          ) : (
            <Menu as="div" className="relative inline-block text-left">
              <MenuButton>
                <UserIcon className="h-8 w-8 text-gray-800" />
              </MenuButton>
                <MenuItems className="absolute right-0 mt-2 w-48 bg-white border rounded-md shadow-lg">
                  <MenuItem>
                    <Link to="/authentication" className="block px-4 py-2 text-sm text-black hover:bg-purple-100">
                      Se connecter
                    </Link>
                  </MenuItem>
                  <MenuItem>
                    <Link to="/registration" className="block px-4 py-2 text-sm text-black hover:bg-purple-100">
                      Créer un compte
                    </Link>
                  </MenuItem>
                </MenuItems>
            </Menu>
          )}
        </div>
      </header>
    );
  }

export default Header;
  