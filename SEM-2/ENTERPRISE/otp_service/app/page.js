import Image from "next/image";
import OTP from "./components/OTP";

export default function Home() {
  return (
    <div className="w-full h-screen flex justify-center items-center">
      <OTP />
    </div>
  );
}
