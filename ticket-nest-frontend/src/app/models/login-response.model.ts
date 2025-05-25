export interface UserData {
    id: number;
    email: string;
    name: string;
    phone: string;
    role: string;
  }
  
  export interface LoginApiResponse {
    data: {
      userData?: UserData;
      token?: string | null;
      message?: string;
      statusCode: number;
    };
  }
  